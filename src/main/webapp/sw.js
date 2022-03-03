
// Constantes
const root = '/TruthCheckJava'

const userURL = root + '/w/user'

const login = userURL + '/login'
const register = userURL + '/register'
const logged = userURL + '/logged'
const logout = userURL + '/logout'

const home = root + '/home'
const welcome = root + '/welcome'
const create = root + '/create' //donde se crean las cosas / la biblioteca personal
const explore = root + '/explore' // donde estan las cosas de todos
const play = root + '/play' // Donde se juega --Comming soon--

// Eventos
self.addEventListener('fetch', handleRequest)
self.onerror = (e) => {
  console.error('Error -->', e)
}

self.addEventListener('install', () => {
  console.log('Instalado')
})

self.addEventListener('activate', () => {
  console.log('Activo')
})

// Utils

function getCacheStorage() {
  return caches.open('TCS')
}
function buildURL(baseURL, params) {
  if (params == null) 
    return baseURL
  let searchParams = '?'
  for (const param in params) {
    if(searchParams != '?'){
      searchParams += '&'
    }
    searchParams += param + '=' + params[param]
  }
  return baseURL + searchParams
}

async function cache(url_or_resource) {
  const res = url_or_resource
  if (res instanceof String) {
    res = fetch(url_or_resource)
  }

  const cache = await getCacheStorage()
  cache.put(await res)
}

async function getFromCache(resourceURL) {
  const cache = await caches.open('TCS')
  return cache.match(resourceURL)
}

async function sendFormData(url, data) {
  return fetch(url, {
    method: 'POST',
    headers: {
      'Content-type': 'application/json; charset=UTF-8'
    },
    body: JSON.stringify(data)
  })
}

async function getPage(url) {

  let page = await getFromCache(url)
  if (page === undefined) {
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
  [logout]: logoutHandler,
}

// Main

async function handleRequest(f) {

  for (const route in routes) {
    if (f.request.url.includes(route)) { // Cambiar include por algo mas seguro
      console.log('Managing :', route)
      f.respondWith(routes[route](f))
      return
    }
  }
  f.respondWith(getPage(f.request.url))
}

// Handlers

async function defaultAction(f) {
  const cachedPage = await getFromCache(f.request.url)
  if (cachedPage !== undefined) {
    return cachedPage
  }
  return fetch(f.request.url) //Creo que esto es getPage
}
async function accountHandler(f, action) {
  const formData = await f.request.formData()

  const user = formData.get('user')
  const password = formData.get('password')

  const log = await sendFormData(action, { 'name': user, 'password': password })
  const error = log.headers.get('error')

  if (error != null) {
    let url = buildURL(welcome, {error: error, user:user})
    return Response.redirect(url)
  }
  return Response.redirect(home)
}
async function loginHandler(f) {
  return accountHandler(f, login)
}
async function registerHandler(f) {
  return accountHandler(f, register)
}
async function logoutHandler(f) {
  await fetch(logout) // Redirigir a donde se pida por la url/post mejor
  return Response.redirect(welcome)
}

