1.  五种情况 
    1.  全局范围内，`this;`, 指向全局对象；
    2.  函数调用， `foo();`, 还是指向全局对象，注意就是函数中的函数调用形式的this也是指向全局对象（错误设计？优良设计？）
    3.  方法调用 ， `test.foo();`, this指向test对象。
    4.  调用构造函数， `new foo();` , 此时在构造函数内部，this指向新创建的对象
    5.  显式的设置this：当使用 Function.prototype 上的 call 或者 apply 方法时，函数内的 this 将会被 显式设置为函数调用的第一个参数。 
            function foo(a, b, c) {}
            var bar = {};
            foo.apply(bar, [1, 2, 3]); // 数组将会被扩展，如下所示
            foo.call(bar, 1, 2, 3); // 传递到foo的参数是：a = 1, b = 2, c = 3
            

2.  一些特列 
    *   函数调用和方法调用 
                Foo.method = function() {
                    var that = this;  
                    function test() {
                        // 使用 that 来指向 Foo 对象
                    }
                    test();
                }
            
    
    *   方法的赋值表达式 
                var test = someObject.methodTest;
                test();
             test()调用时，methodTest()中的this已经不指向somObject对象了，测试也不指向test.