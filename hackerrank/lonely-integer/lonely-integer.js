function lonelyinteger(a) {
  const info = Array(101);
  [...Array(101).keys()].forEach(i => info[i] = {num : i, count : 0});
  
  a.forEach(num => info[num].count++);
  
  return info.filter(v => v.count === 1)[0].num;
}
