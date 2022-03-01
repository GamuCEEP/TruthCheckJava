
// Constantes
const root = '/TruthCheckJava'

const userURL = root + '/w/user'

const login = userURL + '/login'
const logout = userURL + '/logout'
const register = userURL + '/register'
const logged = userURL + '/logged'

const home = root + '/home'
const welcome = root + '/welcome'
const workspace = root + '/workspace'
const library = root + '/library'
const gallery = root + '/gallery'

// Eventos
self.addEventListener('fetch', handleRequest)
self.onerror = (e) => {
  console.error('Onerror triggered', e)
}

self.addEventListener('install', () => {
  console.log('Instalado')
})

self.addEventListener('activate',()=>{
  console.log('Activo')
})

// Utils

function getCacheStorage(){
  return caches.open('TCS')
}

async function cache(url_or_resource){

  const res = url_or_resource
  if(res instanceof String){
    res = fetch(url_or_resource)
  }

  const cache = getCacheStorage()
  await cache.put(await res)
}

async function getFromCache(resource){
  const cache = await caches.open('TCS')
  return cache.match(resource)
}

async function sendFormData(url, data){
  return fetch(url, {
    method: 'POST',
    headers: {
      'Content-type': 'application/json; charset=UTF-8'
    },
    body: JSON.stringify(data)
  })
}

async function getPage(url){

  let page = await getFromCache(url)
  if(page === undefined){
    page = fetch(url)
    cache(page)
  }

  return page
}


// Rutas

const routes = {
  [home]: defaultAction,
  [login]: loginHandler,
  [register]: registerHandler,

}

// Main

async function handleRequest(f) {
  for (const route in routes) {
    if (f.request.url.includes(route)) {
      console.log('Executing :',route)
      f.respondWith(routes[route](f))
    }
  }
}

// Handlers

async function defaultAction(f){
  const cachedPage = await getFromCache(f.request.url)
  if(cachedPage !== undefined){
    return cachedPage
  }
  return fetch(f.request.url) //Creo que esto es getPage
}

async function registerHandler(){
  const formData = await f.request.formData()

  const user = formData.get('user')
  const password = formData.get('password')

  const log = sendFormData(register, {'name': user, 'password': password})
}

async function loginHandler(f) {
  
  const formData = await f.request.formData()

  const user = formData.get('user')
  const password = formData.get('password')
  
  const log = await sendFormData(login, {'name':user,'password':password})
  const error = log.headers.get('error')
  
  if (error != null) {
    return Response.redirect(welcome + `?error=${error}&user=${user}`)
  }
  
  cache(logged)

  return Response.redirect(home)
}