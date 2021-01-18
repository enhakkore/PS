/**
 * @param {number} n
 * @return {number}
 */
var numberOfMatches = function(n) {
  let sum = 0;
  while(n > 1){
      const a = Math.floor(n/2);
      const b = n - a;
      sum += a;
      n = b;
  }
  return sum;
};
