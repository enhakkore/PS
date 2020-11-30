function solution(participant, completion) {
  const stock = new Map();
  participant.forEach((player) => {
      const val = stock.get(player);
      if(val) stock.set(player, val+1);
      else stock.set(player, 1);
  });

  completion.forEach((player) => {
      const val = stock.get(player);
      stock.set(player, val-1);
  });

  let answer;
  stock.forEach((v, k, map) => {if(v === 1) answer = k;});
  return answer;
}
