"use strict";
Object.defineProperty(exports, "__esModule", { value: true });
require("./scss/styles.scss");
/**
 * Variable and Data type
 */
// tslint:disable
/**
 * var vs let/const
 */
(function main() {
    console.log("START");
    if (true) {
        var lang = "vi";
        let target = "en-us";
        console.log("inside block");
        console.log(target);
    }
    console.log(lang);
    //Lỗi không khai báo target
    //console.log(target);
})();
(function main() {
    var x = 5;
    console.log(x);
    var x = 10;
    console.log(x);
    //Lỗi y sử dụng let ko tạo trong block
    // let y = 55;
    // console.log(y);
    // let y = 100;
    // console.log(y);
})();
(function main() {
    console.log(x);
    var x = 5;
    //Lỗi y sử dụng trước khi khai báo
    // console.log(y);
    // let y = 10;
})();
/**
 * Data types
 */
(function main() {
    let message;
    let total = 100;
    let isProduction = true;
    let prices = [120, 88, 60];
    let languages = ['vi', 'en-us'];
    let now = new Date();
    let unknown;
    let Direction;
    (function (Direction) {
        Direction[Direction["UP"] = 0] = "UP";
        Direction[Direction["DOWN"] = 1] = "DOWN";
        Direction[Direction["LEFT"] = 2] = "LEFT";
        Direction[Direction["RIGHT"] = 3] = "RIGHT";
    })(Direction || (Direction = {}));
    ;
    function log(msg) {
        console.log(msg);
    }
    isProduction = false;
    unknown = Direction.UP;
    unknown = 'changed';
    //Lỗi không khởi tạo post bằng IPost vì thiếu trường id,... trong {}
    const post = {
        id: "XuanDuy",
        title: "21 years old not girl friends",
        body: "Thin"
    };
    //Lỗi gán số cho chuỗi
    //message = 50;
    function getPost(postId) {
        // do something to retrieve post
        return {
            id: postId,
            title: 'Post Title',
            body: 'Post Body',
            extra: 'data'
        };
    }
})();
function main() { }
// tslint:enable
main();
