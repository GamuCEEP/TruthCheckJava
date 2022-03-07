
// Constantes
const root = '/TruthCheckJava'

const userURL = root + '/w/user'

const login = userURL + '/login'
const register = userURL + '/register'
const logged = userURL + '/logged'
const logout = userURL + '/logout'

const createItem = userURL + '/item'
const createActor = userURL + '/actor'
const createStage = userURL + '/stage'
const createInteracion = userURL + '/interaction'
const createEvent = userURL + '/event'
const createEffect = userURL + '/effect'
const createMap = userURL + '/map'

const storeItem = root + '/w/item'
const storeActor = root + '/w/actor'
const storeStage = root + '/w/stage'
const storeInteracion = root + '/w/interaction'
const storeEvent = root + '/w/event'
const storeEffect = root + '/w/effect'
const storeMap = root + '/w/map'

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
    if (searchParams != '?') {
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
  // resource creation
  [create + '?item']: createItemHandler,
  [create + '?actor']: createActorHandler,
  [create + '?stage']: createStageHandler,
  [create + '?interacion']: createInteracionHandler,
  [create + '?event']: createEventHandler,
  [create + '?effect']: createEffectHandler,
  [create + '?map']: createMapHandler,
}
// Main
async function handleRequest(f) {

  for (const route in routes) {
    if (f.request.url.includes(route)) { // Cambiar include por algo mas seguro
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
    let url = buildURL(welcome, { error: error, user: user })
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
  const formData = await f.request.formData()
  const url = formData.get('to')
  return Response.redirect(url)
}





async function createItemHandler(f) {
  const formData = await f.request.formData()
}
async function createActorHandler(f) {
  const formData = await f.request.formData()
}
async function createStageHandler(f) {
  const formData = await f.request.formData()
}
async function createInteracionHandler(f) {
  const formData = await f.request.formData()
}
async function createEventHandler(f) {
  const formData = await f.request.formData()
}
async function createEffectHandler(f) {
  const formData = await f.request.formData()
  const store = await sendFormData(storeEffect, {
    name: formData.get('name'),
    description: formData.get('description'),
    code: formData.get('code')
  })
  const effect = await fetch('/TruthCheckJava/w/effect/named/'+formData.get('name'))
  const resp = await fetch(createEffect,{method: 'post',body: effect.id})
  console.log(store.status, effect.status, resp.status, effect.id)
  return welcome
}
async function createMapHandler(f) {
  const formData = await f.request.formData()
}

