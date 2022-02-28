$ = e => document.querySelector(e)
$$ = e => document.querySelectorAll(e)


function show(e) {
  let id = e.startsWith('#') ? e : `#${e}`
  $(id).setAttribute('style', 'display: block')
}

function clearURL() {
  const currentURL = window.location.href.replace(window.location.search, '')
  window.history.replaceState({}, document.title, currentURL)
}

async function getUser() {
  // let cache = await caches.open('TCS')

  // const resp = await cache.match('/TruthCheckJava/webresources/user/logged')
  // console.log(resp)
  // if (resp === undefined)
  //   return null

  // const user = await resp.json()

  // return user
  return 'FakeUser'
}

