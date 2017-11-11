import {Spacecraft, Containership} from './base-ships'

class MillenniumFalcon extends Spacecraft implements Containership{

  cargoContainers: number;

  constructor(){
    super('hiperdrive');
    this.cargoContainers = 2;
  }

  jumpIntoHyperspace(){
    if (Math.random() >= 0.5){
      super.jumpIntoHyperspace();
    } else {
      console.log('Fail');
    }
  }
}

export {MillenniumFalcon}
