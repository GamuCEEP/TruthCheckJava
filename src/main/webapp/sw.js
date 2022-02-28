const root = '/TruthCheckJava'

const resourceURL = root + '/w/user'

const login = resourceURL + '/login'
const logout = resourceURL + '/logout'
const register = resourceURL + '/register'
const logged = resourceURL + '/logged'
// Puede que en el futuro modifique para que se pidan al servidor las rutas
// Poniendolo en el oninstall
const home = root + '/home'
const welcome = root + '/welcome'
const workspace = root + '/workspace'
const library = root + '/library'
const gallery = root + '/gallery'


self.addEventListener('fetch', handleRequest)
self.onerror = (e) => {
  console.error('Onerror triggered', e)
}

self.addEventListener('install', () => {
  console.log('Instalado')
})


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



const routes = {
  [home]: defaultAction,
  [login]: loginHandler,
  [register]: registerHandler,

}

async function handleRequest(f) {
  for (const route in routes) {
    if (f.request.url.includes(route)) {
      f.respondWith(routes[route](f))
    }
  }
}

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

  const log = await fetch(register, {
    method: 'POST',
    body: JSON.stringify({
      'name': user,
      'password': password
    }),
    headers: {
      'Content-type': 'application/json; charset=UTF-8'
    }
  })
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




// async function authenticate(f) {

//   const formData = await f.request.formData()
// // Debería cojerlo del post y de las cookies/donde sea que lo ponga
//   const u = formData.get('user')
//   const p = formData.get('password')

//   console.log('pepe')
//   console.log(u, p, 'patata')

//   if (u == null || p == null) {
//     console.log('UOUOUOUOUOUO tio las credenciales')
//     f.respondWith(Response.redirect(`${welcome}?error=UserOrPasswordEmpty`))
//   }

//   const userObj = {
//     name: u,
//     password: p
//   }

//   const url = (formData.get('action') == 'Entrar') ? login : register

//   const response = fetch(url, { body: userObj })


//   //const response = fetch("/TruthCheckJava/home",{method: "GET"})
//   // f.respondWith(response)
// }


function loggedUser(f) {
  const sessionCookie = getCookie('JSESSIONID')
  console.log(sessionCookie)
  return fetch(home, {})
}

