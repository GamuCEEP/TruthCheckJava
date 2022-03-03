// values = {key: value, ...}
async function getTemplate(url, values){

  const templateString = await loadTemplate(url)

  const filledTemplate = fillTemplate(templateString, values)

  return inflateTemplate(filledTemplate)

}

async function loadTemplate(url){
  const resp = await fetch(url)
  return resp.text()
}
function fillTemplate(genericTemplateString,values){
  let res = genericTemplateString
  for(const value in values){
    const regex = new RegExp(`_(${value})`, 'g')
    res = res.replace(regex, (match, p1)=>{
      console.log(match, p1)
      return values[p1]
    })
  }
  return res
}
function inflateTemplate(templateString){
  const template = document.createElement('template')
  template.innerHTML = templateString
  return template
}



