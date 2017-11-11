class Spacecraft{
  propulsor: string;

  constructor(propulsor: string){
    this.propulsor = propulsor;
  }

  jumpIntoHyperspace(){
    console.log(`Entering hyperspace with ${this.propulsor}`);
  }
}

interface Containership{
  cargoContainers: number;
}

export {Spacecraft, Containership}
