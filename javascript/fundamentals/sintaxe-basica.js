// 1. Variaveis e tipos de dados

let nome = "Jobert";
let idade = 18;
let estudaJava = true;
let telefone;
let email = null;

console.log(nome);
console.log(idade);
console.log(estudaJava);
console.log(telefone);
console.log(email);


// 2. Null, NaN e typeof

let valor = null;

console.log(valor * 2);
console.log(NaN === NaN);
console.log(typeof NaN);


// 3. Igualdade frouxa e igualdade estrita

valor = "18";

console.log(idade == valor);
console.log(idade === valor);


// 4. Conversao explicita de tipos

const numero = Number("25");
const texto = String(25);
const booleano = Boolean(25);

console.log(numero + 1);
console.log(texto + 1);
console.log(booleano + 1);

console.log(Number("cabrito"));
console.log("cabrito" * 2);


// 5. Truthy e falsy

if (1) {
    console.log("peidou");
} else {
    console.log("nao peidou");
}

const idade2 = 0;

if (idade2 !== null && idade2 !== undefined) {
    console.log("existe");
} else {
    console.log("nao existe");
}


// 6. Constantes e mutabilidade

const nomeConstante = "Jobert";
// nomeConstante = "Goat";

const listaConstante = ["Jobert"];

console.log(listaConstante);

listaConstante[0] = "Goat";

console.log(listaConstante);


// 7. Escopo com var e let

if (true) {
    var linguagem = "JavaScript";
}

let linguagemSecundaria = "Java";

console.log(linguagem);
console.log(linguagemSecundaria);
console.log(linguagemSecundaria !== linguagem);


// 8. Condicionais

if (idade >= 18) {
    console.log("maior de idade");
} else {
    console.log("menor de idade");
}

const resultado = idade >= 18
    ? "Maior de idade"
    : "Menor de idade";

console.log(resultado);


// 9. Switch

const statusPagamento = "paid";

switch (statusPagamento) {
    case "pending":
        console.log("pagamento pendente");
        break;

    case "paid":
        console.log("pagamento concluido");
        break;

    case "failed":
        console.log("pagamento falhou");
        break;

    default:
        console.log("status desconhecido");
}


// 10. Arrays e loops

const linguagens = ["JavaScript", "Java", "Python", "C"];

for (const linguagemAtual of linguagens) {
    console.log(linguagemAtual);
}

for (const indice in linguagens) {
    console.log(indice);
}

console.log(linguagens[0]);
console.log(linguagens[1]);

linguagens.push("C++");

console.log(linguagens[4]);
console.log(linguagens.length);

// 11. Funcoes

function verificarMaiorIdade(idade){
    if(idade >= 18){
        return "maior de idade";
    } else {
        return "menor de idade";
    }
}

console.log(verificarMaiorIdade(12));

function apresentarPessoa(nome, idade){
    const maiorDeIdade = verificarMaiorIdade(idade);
    return `Ola meu nome e ${nome}, e tenho ${idade} anos! \n${nome} e ${maiorDeIdade}`; 
}

console.log(apresentarPessoa("Jobert", "16"));

function imprimirMensagem(mensagem){
    console.log(mensagem);
}

const retorno = imprimirMensagem("testando funcao");
console.log(retorno);
