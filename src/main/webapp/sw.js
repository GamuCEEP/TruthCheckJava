

self.addEventListener('fetch', handleRequest)

self.addEventListener('install', () => {
  console.log('Instalado')
})

async function handleRequest(f) {

  console.log("Pero wenooooo")
  
  if (/login/.test(f.request.url)){
    console.log("Te estas logueando, que pillin")
    console.log(f.request.body)
    f.respondWith()
  }

}

