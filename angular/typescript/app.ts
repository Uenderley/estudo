let message: string = "Hello"
console.log(message);

let episode: number = 4
console.log("This is episode "+4)
episode = episode + 1
console.log("Next episode is "+episode);

let isEnoughToBeatMF = function (parsecs: number): boolean {
    return parsecs < 12;
}
let distance = 14;
console.log(`Is ${distance} parsecs ? ${isEnoughToBeatMF(distance) ? 'Yes' : 'No'}`);

let call = (name: string) => console.log(`Do you copy, ${name}?`);
call('R2');

function inc(speed: number, inc: number = 1): number{
  return speed + inc;
}
console.log(`inc (5,1) = ${inc(5,1)}`);
console.log(`inc (5) = ${inc(5)}`);
