let line;
let stack1 = [];
let stack2 = [];
while(line = readline()) {
    let lines =line.split(' ');
    const maps = {
        'add': myAdd,
        'peek': myPeek,
        'poll': myPoll
    };
    if(isNaN(Number(lines[0]))) {
        maps[lines[0]](lines[1])
    };
}

function myAdd(val) {
    stack1.push(val);
}
// 查询
function myPeek() {
    if(!stack2.length){updatePop()};
    console.log([...stack2].pop())
}
function myPoll() {
    if(stack2.length) {
        stack2.pop();
    } else {
        updatePop();
        stack2.pop();
    }
}
function updatePop() {
    stack1.forEach(item => {
        stack2.unshift(item)
    });
    stack1 = [];
}