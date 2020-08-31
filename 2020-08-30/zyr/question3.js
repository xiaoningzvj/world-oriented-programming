let num = readline();
let lines = readline().split(' ');
function getLast(stack) {
    const res = stack.pop();
    if(!stack.length) {
        return res;
    } else {
        const last = getLast(stack);
        stack.push(res);
        return last;   
    }
}
function reverse(stack) {
    if(!stack.length) {
        return;
    } 
    const i = getLast(stack);
    reverse(stack)
    stack.push(i);
}
reverse(lines);
print(lines.join(' '))