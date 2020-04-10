import {soma} from './functions';

class List {
    constructor() {
        this.data = [];
    }
    
    add(data){
        this.data.push(data);
        console.log(data);
    }
}

class TodoList extends List{
    constructor() {
        super();
        this.usuario = 'Uenderley';
    }
    
    mostraUsuario() {
        console.log(this.usuario);
    }
   
}

const MinhaLista = new TodoList();

document.getElementById('novotodo').onclick = function() {
    MinhaLista.add('Novo Todo');
}

const arr = [1,2,3,4,5,6,7,8,9];
const newArr = arr.map(function(item) {
   return item * 2; 
});
console.log(newArr);

const newArr2 = arr.map(item => item * 2);
console.log(newArr2);

console.log(soma(10, 2));