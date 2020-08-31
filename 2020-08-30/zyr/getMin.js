let line;
let arr  =  [];
let len = 0;
let minarr = [];
while(line=readline()){
    let lines = line.split(' ');
    const isMumber = parseInt(lines[0]);
    len = len ? len : isMumber;
    const maps = {
        'push': myPush,
        'pop': myPop,
        'getMin': getMin
    };
    // 执行操作
    if(isNaN(isMumber)) {
         maps[lines[0]](lines[1])
    }
}
function myPush(val){
    const al = arr.length;
    if(al < len) {
        arr.push(val);
        const min = [...minarr].pop();
        if(al && ((min - val) <= 0)) {
            minarr.push(min)
        } else {
            minarr.push(val)
        }
    }
}
function myPop(val) {
    arr.pop();
    minarr.pop();
}
function getMin() {
    console.log([...minarr].pop());
}