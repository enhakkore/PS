function solution(n, computers) {
  const visited = Array(n);
  [...Array(n).keys()].forEach(i => visited[i] = false);
  
  let count = 0;
  for(let i = 0; i < n ; i++){
      if(visited[i]) continue;
      
      count++;
      const stock = [i];
      
      while(stock.length > 0){
          const node = stock.pop();
          if(visited[node]) continue;
          
          visited[node] = true;
          computers[node][node] = 0;
          computers[node].forEach((next, idx) => {
              if(next === 1){
                  stock.push(idx);
              }
          });
      }
  }
  
  return count;
}
