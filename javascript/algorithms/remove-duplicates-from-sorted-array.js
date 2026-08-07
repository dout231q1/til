const numeros = Object.seal([1,2,3,2,10,5,1,2,0,1]);

console.log(numeros.length);

numeros.sort((a, b) => a - b);
console.log(numeros);
let k = 1;

for(let i = 1; i < numeros.length; i++){
    if(numeros[i] != numeros[i-1]){
        numeros[k] = numeros[i];
        k++
    }
    console.log(numeros);
}

console.log(k);