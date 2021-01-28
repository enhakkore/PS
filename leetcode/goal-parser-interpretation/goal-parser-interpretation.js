/**
 * @param {string} command
 * @return {string}
 */
const interpret = function(command) {
  command = [...command];
  const parsedCommand = [];
  const stock = [];
  while(command.length > 0) {
      const char = command.shift();
      if(char === "G") {
          parsedCommand.push(char);
      }
      
      if(char === "(" || char === "a" || char === "l") {
          stock.push(char);
      }
      
      if(char === ")"){
          if(stock.length === 1) parsedCommand.push("o");
          if(stock.length === 3) parsedCommand.push("al");
          stock.length = 0;
      }
  }
  
  return parsedCommand.join("");
};


// other way
/**
* @param {string} command
* @return {string}
*/
const interpret2 = function(command) {
  return command.replace(/(\(\))|(G)|(\(al\))/g, s => {
      if(s === "G") return s;
      if(s === "()") return "o";
      if(s === "(al)") return "al";
  });
}
