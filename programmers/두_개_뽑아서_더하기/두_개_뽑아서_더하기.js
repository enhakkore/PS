function solution(numbers) {
  const stock = new Set();
  for(let i = 0 ; i < numbers.length ; i += 1) {
      for(let j = i+1 ; j < numbers.length ; j += 1){
          stock.add(numbers[i]+numbers[j]);
      }
  }
  
  const answer = [...stock];
  answer.sort((a, b) => a-b);
  return answer;
}
