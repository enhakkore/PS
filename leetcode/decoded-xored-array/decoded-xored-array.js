/**
 * @param {number[]} encoded
 * @param {number} first
 * @return {number[]}
 */
const decode = function(encoded, first) {
  const arr = [first];
  
  for(let i = 0 ; i < encoded.length ; i++) {
      arr[i+1] = arr[i] ^ encoded[i];
  }
  
  return arr;
};
