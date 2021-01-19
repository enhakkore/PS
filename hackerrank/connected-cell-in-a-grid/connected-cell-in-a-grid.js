'use strict';

const fs = require('fs');

process.stdin.resume();
process.stdin.setEncoding('utf-8');

let inputString = '';
let currentLine = 0;

process.stdin.on('data', inputStdin => {
    inputString += inputStdin;
});

process.stdin.on('end', function() {
    inputString = inputString.replace(/\s*$/, '')
        .split('\n')
        .map(str => str.replace(/\s*$/, ''));

    main();
});

function readLine() {
    return inputString[currentLine++];
}

// Complete the maxRegion function below.
function maxRegion(grid) {
    const tr = [1, -1, 0, 0, 1, -1, 1, -1];
    const tc = [0, 0, 1, -1, -1, 1, 1, -1];
    
    let largestRegion = 0;
    
    for(let r = 0 ; r < grid.length ; r++){
        for(let c = 0 ; c < grid[r].length ; c++){
            if(grid[r][c] !== 1) continue;
            
            let area = 0;
            const stock = [{row : r, col : c}];
            while(stock.length > 0){
                const cur = stock.pop();
                
                if(grid[cur.row][cur.col] === 0) continue;
                grid[cur.row][cur.col] = 0;
                area++;
                
                for(let i = 0; i < 8 ; i++){
                    const row = cur.row + tr[i];
                    const col = cur.col + tc[i];
                    
                    if(row >= grid.length || row < 0 || col >= grid[r].length || col < 0) continue;
                    if(grid[row][col] === 0) continue;
                    
                    stock.push({row, col});
                }
            }
            
            largestRegion = Math.max(area, largestRegion);
        }
    }
    
    return largestRegion;
}

function main() {
    const ws = fs.createWriteStream(process.env.OUTPUT_PATH);

    const n = parseInt(readLine(), 10);

    const m = parseInt(readLine(), 10);

    let grid = Array(n);

    for (let i = 0; i < n; i++) {
        grid[i] = readLine().split(' ').map(gridTemp => parseInt(gridTemp, 10));
    }

    const res = maxRegion(grid);

    ws.write(res + '\n');

    ws.end();
}
