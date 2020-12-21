/**
 * @param {number[][]} accounts
 * @return {number}
 */
var maximumWealth = function(accounts) {
  let max = 0;
  for(let m = 0 ; m < accounts.length ; m++){
      let sum = 0;
      let account = accounts[m];
      for(let n = 0 ; n < account.length ; n++){
          sum += account[n];
      }
      max = Math.max(max, sum);
  }
  
  return max;
};