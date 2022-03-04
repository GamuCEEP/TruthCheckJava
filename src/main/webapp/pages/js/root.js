$ = (e, from = null) => from ? from.querySelector(e) : document.querySelector(e)
$$ = (e, from = null) => from ? from.querySelectorAll(e) : document.querySelectorAll(e)
_ = (type) => document.createElement(type)

const getKeyByValue = (obj, value) => 
        Object.keys(obj).find(key => obj[key] === value);


function show(e) {
  let id = e.startsWith('#') ? e : `#${e}`
  $(id).setAttribute('style', 'display: block')
}

function clearURL() {
  const currentURL = window.location.href.replace(window.location.search, '')
  window.history.replaceState({}, document.title, currentURL)
}

async function getUser() {
  return getData('/TruthCheckJava/w/user/logged')
}

async function getResourceTypes() {
  return getData('/TruthCheckJava/w/util/resourceTypes')
}

async function getData(url) {
  const resp = await fetch(url)
  return resp.json()
}

function getUserLikedResources(user, type = '', filter = '') {
  return filterUserResources(user, 'Collection', type, filter)
}

function getUserCreatedResources(user, type = '', filter = '') {
  return filterUserResources(user, 'created', type, filter)
}

function filterUserResources(user, relation = '', type = '', filter = '') {
  const resp = {}
  for (const field in user) {
    if (!field.includes(relation)) continue
    if (!field.includes(type)) continue

    for (const resource of user[field]) {
      const id = resource.id + '';
      const name = resource.name + '';
      const description = resource.description + '';
      if (!id.includes(filter) && !name.includes(filter) && !description.includes(filter)) continue

      const type = field.replace(relation, '')
      if (resp[type] == undefined) {
        resp[type] = []
      }
      resp[type].push(resource)
    }
  }
  return resp
}


function createResourceView(resource, depth = -1) {
  if (depth == 0) return
  depth--
  const container = _('div')
  for (const field in resource) {
    let inp;
    if (['string', 'number'].includes(typeof field)) {
      inp = _('p')
      inp.innerText = field
    } else {
      inp = createResourceView(field, depth)
    }
    container.append(inp)
  }
  return container
}





