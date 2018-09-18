function $(id) {
  return document.getElementById(id);
}

function firstExample() {
  fetch("./first")
    .then(resp => resp.json())
    .then(data => {
      console.log(data);
    });
}
function secondExample() {
  let body = {
    string: $("nameInp").value,
    list:$('langInp').value.split(',')
  };
  fetch("./first", { method: "POST", body:JSON.stringify(body) })
    .then(resp => resp.json())
    .then(data => {
      console.log(data);
    });
}
function thirdExample() {
  fetch(`./second?age=${$("ageInp").value}`)
    .then(resp => resp.json())
    .then(data => {
      console.log(data);
    });
}
function fourthExample() {
    let body = {
        string: $("nameInp2").value,
        list:$('langInp2').value.split(',')
      };
  fetch("./second", { method: "POST", body:JSON.stringify(body) })
    .then(resp => resp.json())
    .then(data => {
      console.log(data);
    });
}

$("firstE").addEventListener("click", firstExample);
$("secondE").addEventListener("click", secondExample);
$("thirdE").addEventListener("click", thirdExample);
$("fourthE").addEventListener("click", fourthExample);
