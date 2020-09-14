// 反转单向链
function LinkNode(val) {
  this.val = val;
  this.next = null;
  this.last = null;
}
// 转成链表  type 1 双链表
function GetList(arr, type = 0) {
  if (!arr.length) return null;
  const header = new LinkNode(arr[0]);
  let tempNode = header;
  for (let i = 1; i < arr.length; i++) {
    const node = new LinkNode(arr[i]);
    tempNode.next = node;
    if (type) {
      node.last = tempNode;
    }
    tempNode = tempNode.next;
  }
  return header;
}
readline();
let list1 = readline().split(' ').map(Number);
list1 = new GetList(list1);
readline();
let list2 = readline().split(' ').map(Number);
list2 = new GetList(list2, 1);

function ReverseList(head, type = 0) {
  let pre = null;
  let next = null;
  while (head) {
    next = head.next;
    head.next = pre;
    if (type && pre) {
      pre.last = head;
    }
    pre = head;
    head = next;
  }
  return pre;
}
// 转成数组输出
const getArray = (list) => {
  const res = [];
  while (list) {
    res.push(list.val);
    list = list.next;
  }
  console.log(res.join(' '));
};
const res1 = new ReverseList(list1);
const res2 = new ReverseList(list2, 1);
getArray(res1);
getArray(res2);
