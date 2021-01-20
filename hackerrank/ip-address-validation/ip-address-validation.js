function processData(input) {
  const ipv4pattern = /^((\d|[1-9]\d|1\d{2}|2[0-4]\d|25[0-5])\.){3}(\d|[1-9]\d|1\d{2}|2[0-4]\d|25[0-5])$/;
  const ipv6pattern = /^([0-9a-fA-F]{1,4}\:){7}([0-9a-fA-F]{1,4})$/;
  
  input = input.split("\n");
  let n = input[0];
  const answer = [];
  do{
      if(ipv4pattern.test(input[n])) answer.push("IPv4");
      else if(ipv6pattern.test(input[n])) answer.push("IPv6");
      else answer.push("Neither");
  }while(--n > 0);
  
  console.log(answer.reverse().join("\n"));
} 

process.stdin.resume();
process.stdin.setEncoding("ascii");
_input = "";
process.stdin.on("data", function (input) {
  _input += input;
});

process.stdin.on("end", function () {
  processData(_input);
});
