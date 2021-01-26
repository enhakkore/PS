/**
 * @param {number} big
 * @param {number} medium
 * @param {number} small
 */
var ParkingSystem = function(big, medium, small) {
  this.slotOfBig = big;
  this.slotOfMedium = medium;
  this.slotOfSmall = small;
};

/** 
* @param {number} carType
* @return {boolean}
*/
ParkingSystem.prototype.addCar = function(carType) {
  switch(carType) {
      case 1 : 
          if(this.slotOfBig > 0) this.slotOfBig--;
          else return false;
          break;
      case 2 :
          if(this.slotOfMedium > 0) this.slotOfMedium--;
          else return false;
          break;
      case 3 :
          if(this.slotOfSmall > 0) this.slotOfSmall--;
          else return false;
  }
  
  return true;
};

/** 
* Your ParkingSystem object will be instantiated and called as such:
* var obj = new ParkingSystem(big, medium, small)
* var param_1 = obj.addCar(carType)
*/
