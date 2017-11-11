import {Spacecraft, Containership} from './base-ships';
import {MillenniumFalcon} from './starfighters';

let ship = new Spacecraft('hyperdrive');
ship.jumpIntoHyperspace();

let millenium = new MillenniumFalcon();
millenium.jumpIntoHyperspace();

let goodForTheJob = ( ship: Containership) => ship.cargoContainers > 1;
console.log(`Is falcon good for the job? ${goodForTheJob(millenium) ? 'yes' : 'no'}`);
