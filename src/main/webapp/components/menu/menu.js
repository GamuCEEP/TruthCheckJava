
; (() => {
  const menuButtons = $$('.menu-button')
  console.log(menuButtons)
  for(const button of menuButtons){
    const menu = nextNonTextSibling(button)
    button.addEventListener('focus', ()=>{
      if(menu.classList.contains('hidden'))
        menu.focus()
    })
    menu.addEventListener('focusout', ()=>{
      menu.classList.add('hidden')
    })
    menu.addEventListener('focusin', ()=>{
      menu.classList.remove('hidden')
    })
  }


  function nextNonTextSibling(node){
    let max = 10
    let lookedNode = node.nextSibling
    while ((lookedNode.nodeType == 3 || lookedNode.nodeType == 8) && max-- > 0) {
      lookedNode = lookedNode.nextSibling
    }
    return lookedNode
  }
})()