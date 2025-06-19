const readline = require('readline');
const rl = readline.createInterface({
    input: process.stdin,
    output: process.stdout
});

let input = [];

rl.on('line', function (line) {
    input = [line];
}).on('close', function () {
    let str = '';
    const line = input[0]; // 첫 번째 줄 문자열

    for(let i = 0; i < line.length; i++) {
        let ch = line[i];

        if(ch === ch.toUpperCase() && ch !== ch.toLowerCase()) {
            str += ch.toLowerCase();
        } else if(ch !== ch.toUpperCase() && ch === ch.toLowerCase()) {
            str += ch.toUpperCase();
        } 
    }

    console.log(str);
});
