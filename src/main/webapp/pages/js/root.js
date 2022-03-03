$ = (e, from = null) => from ? from.querySelector(e) : document.querySelector(e)
$$ = (e, from = null) => from ? from.querySelectorAll(e) : document.querySelectorAll(e) 


function show(e) {
  let id = e.startsWith('#') ? e : `#${e}`
  $(id).setAttribute('style', 'display: block')
}

function clearURL() {
  const currentURL = window.location.href.replace(window.location.search, '')
  window.history.replaceState({}, document.title, currentURL)
}

async function getUser() {
  const resp = await fetch('/TruthCheckJava/w/user/logged')
  return resp.json()
}

