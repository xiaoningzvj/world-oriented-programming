const nums = readline().split(' ').map(Number);
let n = nums[0], k = nums[1];

function linkNode(val) {
    this.value = val;
    this.next = null;
}
// 转成链表
function getList(arr) {
    if(!arr.length) return null;
    const header = new linkNode(arr[0]);
    let tempNode = header;
    for(let i = 1; i< arr.length; i++) {
        const node = new linkNode(arr[i]);
        tempNode.next = node;
        tempNode = tempNode.next;
    }
    return header;
}
// 链表转数组
const getArray = (list) => {
    let res = [];
    while(list) {
        res.push(list.value);
        list = list.next;
    };
    print(res.join(' '))
} 
let list = new getList(readline().split(' '));
let pointer = list; 
while(pointer) {
    k--
    pointer = pointer.next;
}
if(k > 1) {
    getArray(list)
} else if(k === 0) {
    // 移除最顶部的节点
    list = list.next;
    getArray(list)
} else {
    // k < 0 的时候
    pointer  = list;
    while( ++k !== 0){
        pointer = pointer.next;
    }
    pointer.next = pointer.next.next;
    getArray(list)
}
