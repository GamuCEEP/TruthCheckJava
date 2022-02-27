const root = '/TruthCheckJava'

const resourceURL = root + '/webresources/user'

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
  console.error(e)
}
self.addEventListener('install', () => {
  console.log('Instalado')
})

const routes = {
  [home]: homeHandler,

}

async function handleRequest(f) {

  for (const route in routes) {
    // Posible punto de ruptura includes comprueba si contiene en cualquier parte
    if (f.request.url.includes(route)) {
      console.log(f.request.url)
      routes[route](f);
    }
  }
}


async function homeHandler(f) {
  console.log('Bienvenido a home')
  try {
    console.log('Cookie desde f: ', f.request.headers.get('Cookie'))
    // mirar por que no va
  } catch (error) {
    console.error(error)
    
  }
  try {
    console.log('loggedUser: ', await loggedUser(f))
  } catch (error) {
    console.error(error)
  }
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


function getCookie(cookie, cookies) {
  for (const c of cookies.split(';')) {
    if (c.trim().beginsWith(cookie)) {
      return c.split('=')[1]
    }
  }
}




// async function log(f) {
//   const formData = await f.request.formData()
//   for (const d of formData) {
//     console.log(d)
//   }
// }
