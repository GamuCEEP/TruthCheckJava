
// Constantes
const root = '/TruthCheckJava'

const resourceURL = root + '/w/user'

const login = resourceURL + '/login'
const logout = resourceURL + '/logout'
const register = resourceURL + '/register'
const logged = resourceURL + '/logged'

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

// Utils

async function cache(resource){
  console.log(`Caching ${resource}`)
  const res = fetch(resource)
  const cache = caches.open('TCS')

  await cache.put(await res)
  console.log(`${resource} cached`)
}

async function getCached(resource){
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
      f.respondWith(routes[route](f))
    }
  }
}

// Handlers

async function defaultAction(f){
  const cachedPage = await getCached(f.request.url)
  if(cachedPage !== undefined){
    return cachedPage
  }
  return fetch(f.request.url)
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

  sendFormData(login, {'name':user,'password':password})

  const error = log.headers.get('error')
  if (error != null) {
    return Response.redirect(welcome + `?error=${error}&user=${user}`)
  }

  cache(logged)

  return Response.redirect(home + `?user=${user}`)
}




