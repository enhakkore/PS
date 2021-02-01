/**
 * @param {string} s
 * @param {number[]} indices
 * @return {string}
 */
let restoreString = function(s, indices) {
  const stock = [];
  [...s].forEach((c, i) => stock[indices[i]] = c);
  return stock.join("");
};
