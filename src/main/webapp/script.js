var titres=document.querySelectorAll("#listTitres li"),
    tab=[];
var descriptions =document.querySelectorAll("#listDescriptions li"),
    desctab=[];
var currentDes= document.querySelector("#currentDescription");
//on remplit le tableau tab setup des indexs
for(var i=0;i<titres.length;i++)
{
    tab.push(titres[i].innerHTML);
    desctab.push(descriptions[i].innerHTML);
    descriptions[i].remove();

}

//fonction on clique sur tous les
for(var i=0;i<titres.length;i++)
{
    console.log(desctab[i]);
    titres[i].onclick=function ()
    {
        index=tab.indexOf(this.innerHTML);
        console.log(this.innerHTML + " index "+ index);
        currentDes.innerHTML=desctab[index];
        console.log(desctab[index]);
    }
}