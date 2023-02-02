## 4 变量、作用域和内存问题

变量的值及其数据类型可以在脚本的生命周期内改变，这既是强大又是易出问题的地方。

### 4.1 基本类型和引用类型的值

js不允许直接访问内存中的位置，就是不能直接操作对象的内存空间；但在为对象添加属性时，操作的是实际的对象。

*   复制变量值

    *   复制基本类型的变量 
    *   复制引用类型的变量时，这个值的副本实际上是一个指针，而这个指针指向存储在堆中的一个对象。复制操作结束后，两个变量实际上将引用同一个对象。 
*   传递参数 
    *   ECMAScript中所有函数的参数都是按值传递的。
    *   向参数传递基本类型值时，值被传递给一个局部变量（arguments对象的一个属性）；传递引用类型值时，会把这个值在内存中的地址复制给一个局部变量（arguments对象的一个属性）。 
*   证明对象是按值传递的例子（可以理解为对象的地址按值传递）：

<pre>function setName(obj){
 obj.name = 'Nicholas';  //此处的obj与person变量指向的同一个对象
 obj = new Object();  // 此处的obj指向另外的对象（一个局部变量）
 obj.name = "Greg";
}
var person = new Object();
setName(person);
alert(person.name); //Nicholas
</pre>


*   检测类型 
    *   `typeof` 主要检测基本类型。ECMA-262规定任何内部实现[[Call]]方法的对象都应该在应用typeof时返回“function”。不同浏览器在检测正则表达式等返回“function”和“object”上有区别。
    *   `instanceof` 检测引用类型是什么类型的对象。 所有引用类型都是Object的实例。 `result = variable instanceof constructor`: 如果变量是给定的引用类型（根据它的原型链来识别）的实例，那result为true。

### 4.2 执行环境及作用域

*   每个执行环境有个对应的**变量对象**（只有解析器访问），执行环境中定义的所有变量和函数都保存在这个变量中。
*   **全局执行环境**是最外围的执行环境（浏览器中是window对象）。 
*   某个执行环境的所有代码执行完毕后，该环境被销毁，保存在其中的所有变量和函数定义也随之销毁（全局执行环境直到应用程序退出（如关闭页面）时才会被销毁）。
*   每个函数都有自己的执行环境，其变量对象中包括arguments。 
*   **作用域链**（scope chain）保证对执行环境有权访问的所有变量和函数的有序访问。 
*   **作用域链的前端**始终是当前执行的代码所在环境的变量对象。全局执行环境的变量对象始终都是作用域链中的最后一个对象。
*   标识符解析始终从作用域链的前端开始沿着作用域链一级一级的搜索，搜索到后搜索结束。 
*   内部环境可以通过作用域链访问所有的外部环境，但相反不行。 

#### 延长作用域链

在作用域链前端临时增加一个变量对象： - try-catch语句中的catch块；（IE<9没有） - with语句； 

<pre>function buildUrl(){ 
var qs = "?debug=true"; 
with(location){ // location被加到作用域链的前端，其中含有href变量
 var url = href + qs; // var定义寻找最近的环境，with语句中最近的环境是函数环境，所以函数中可以调用url 
} 
return url; } 
</pre>


#### 没有块级作用域

*   var声明变量会被自动添加到最接近的环境中。没有var则被添加到全局环境。 
*   查询变量是有代价的，访问局部变量要比全局变量快。（差距随着js引擎在减小）

### 4.3 垃圾收集

*   js有自动垃圾收集机制 原理：找到那些不再继续使用的变量（i打上标记），然后在适当时候释放 两中打标记的方法： 
*   标记清除（mark-and-sweep）:主流方式 
*   引用计数（reference counting）:跟踪记录每个值被引用的次数。 
    *   问题：**循环引用** + 只要在IE中涉及COM对象，就会存在循环引用的问题。 
    *   手工断开js对象与dom对象的连接：将变量设置为null意味着切断变量与它引用的值之间的连接。当垃圾收集器下场运行时，就会删除并回收它们占用的内存。， 

### 小结

*   局部变量会在离开执行环境是自动解除引用，用null解除应用适用于全局变量和全局变量属性，以及循环引用变量的引用。 
*   基本类型-栈内存，引用类型-堆内存



## 5 引用类型



## 6 面向对象的程序设计

### 理解对象

属性类型：属性（property）的特性（attribute）只能内部js引擎调用 * 数据属性 - [[Configurable]] : delete - [[Enumerable]] : for-in - [[Writbale]] : 属性的值是否可修改，默认是true - [[Value]] : 属性的数据值 - 修改属性默认的特性: `Object.defineProperty()`。 参数： 属性所在对象，属性的名字，描述符对象。描述符对象的属性必须是上述的数据属性。 * 访问器属性 - [[Configurable]] : delete - [[Enumerable]] : for-in - [[Get]] : 在读取属性时调用的函数。 - [[Set]] - 访问器属性的定义：`Object.defineProperty(o,name,desc)`. name是属性名，desc是属性描述（特性）

#### 定义多个属性

`Object.defineProperties(o,names)`

#### 读取属性的特性：

`Object.getOwnPropertyDescriptor(o,name)`. o是属性所在的对象，name是属性名，函数返回对应属性特性所组成的对象。

### 创建对象

#### 工厂模式

用函数来封装以特定接口创建对象的细节。

<pre>function createPerson(name,age,job){
  var person = new Object();
  person.name = name;
  person.age = age;
  person.job = job;
  person.sayName = function(){
    alert(this.name);
  }
  return person;
}
var person1 = createPerson('andy', 26, 'phper');
var person2 = createPerson('linus', 40, 'linux');
</pre>


**缺点**：对象不能识别，全是直接继承Object类型。

#### 构造函数模式

用来创建特定类型的对象。

<pre>function Person(name,age,job){
  this.name = name;
  this.age = age;
  this.job = job;
  this.sayName = function(){
    alert(this.name);
  }
}
var person1 = new Person('andy', 26, 'phper');
var person2 = new Person('linus', 40, 'linux');
</pre>


*   与工厂模式的区别 
    *   没有显式创建对象，用new
    *   直接将属性和方法赋值个this，关于[this几种不同用法][1]
    *   没有return

<pre>alert(person1 instanceof Person)</pre>

*   构造函数创建对象的过程 1）创建一个新对象  
    2）将构造函数的作用域赋给新对象（this指向新对象）  
    3）执行构造函数中的代码（为新对象添加属性） 4）返回新对象
*   创建自定义的构造函数（相对于原生构造函数，如Object，Array等）意味着可以将它的实例标识为一个特定的类型。
*   **缺点** 
    *   每个方法都要在每个实例上重新创建一遍，即不同实例上的同名函数是不相等的。

<pre>alert(person1.sayName == person2.sayName);  //false</pre>

*   改进,让不同实例能共享方法

<pre>function Person(name,age,job){
  this.name = name;
  this.age = age;
  this.job = job;
  this.sayName；
}
function sayName(){
    alert(this.name);
}
var person1 = new Person('andy', 26, 'phper');
var person2 = new Person('linus', 40, 'linux');
</pre>


*   改进后的缺点

#### 原型模式

[1]: http://andyron.cn/archives/94



## 8 BOM

> 利用BOM(Browser Object Model)控制浏览器显示的页面以外的部分

### window 对象

window对象是浏览器的一个实例。它既是*js访问浏览器窗口的一个接口*,又是*ECMAScript规定的Global对象*。



## 10 DOM

> DOM已经成为表现和操作页面标记的真正的夸平台、语言中立的方式。

### 节点层次

*文档元素*：文档的最外层元素（HTML文档始终是元素，XML文档不确定）。</p> 

#### Node类型

Node接口由DOM中的所有节点类型实现（除IE）。  
js中所有节点类型都继承自Node类型，因此所有节点类型共享相同的基本属性和方法（nodeType）。  
12种节点类型由1-12的数值表示：(其中元素和文本节点最常用，也就是1和9)

*   **Node.ELEMENT_NODE**:1 元素节点
*   **Node.ATTRIBUTE_NODE**:2 属性节点
*   **Node.TEXT_NODE**:3 文本节点
*   **Node.CDATA_SECTION_NODE**:4 
*   **Node.ENTITY_REFERENCE_NODE**:5 
*   **Node.ENTITY_NODE**:6
*   **Node.PROCESSING_INSTRUCTION_NODE**:7
*   **Node.COMMENT_NODE**:8 注释节点
*   **Node.DOCUMENT_NODE**:9 文档节点
*   **Node.DOCUMENT_TYPE_NODE**:10
*   **Node.DOCUEMNT_FRAGMENT_NODE**:11
*   **Node.NOTATION_NODE**:12

##### 属性和方法

| **属性**  | **元素节点** | **属性节点** | **文本节点** | **文档节点** |
| --------- | ------------ | ------------ | ------------ | ------------ |
| nodeName  | 标签名称     | 属性名称     | #text        | #document    |
| nodeValue | null         | 属性值       | 文本         | null         |

* `nodeType` 

* `childNodes`(NodeList对象，类数组，item())  
  把类数组转变成数组 `var arrayOfNodes = Array.prototype.slice.call(someNode.childNodes,0)`

* `parentNode`

* `previousSibling`

* `nextSibling`

* `firstChild`

* `lastChild`

* `hasChildNodes()`

* `ownerDocument` : 指向整个文档的文档节点。

  > 任何节点都不能同时存在于两个或更多个文档中， 也不能同时出现在文档中的多个位置上。

* `appendChild()`

* `insertBefore()`

* `replaceChild(newNode,oldNode)` 被替换的节点在文档中已经没有了自己的位置。

* `removeChild()`

* `cloneNode(bool)` 深度复制包括子节点。 不会复制添加到DOM节点中的js属性。

#### Document类型

在浏览器中，document对象是HTMLDocument（继承自Document类型）的一个实例，表示怎个HTML页面。

*   三个属性documentElement,firstChild和childNodes[0]的值相同 
*   `document.doctype`(DocumentType，不同浏览其不同)
*   `URL` , `referrer`这两个属性不可以设置（设置后还是原值）
*   `title`, `domain` 可以修改，但`domain`只能修改为子域名（把原本域名是不同子域名的不同框架中的域名改成相同，相互之间js就可以通行了）
*   查找元素的方法 
    *   getElementById():IE7中会获得name属性与所给id相同的元素，所以应不让表单标签的name属性与其他元素的id相同。
    *   getElementsByTagName():结果是`HTMLCollection`对象（类数组，有length，item(),namedItem()）
    *   getElementsByName(): `HTMLCollection`
*   特殊集合(都是`HTMLCollection`) 
    *   document.anchors : 带name属性的a标签 document.forms : document.images : document.links : 带href的a标签
*   DOM一致性检测 document.implementation.hasFeature(feature,version),用于检测浏览器实现了DOM的那些部分。
*   文档写入 write(), writeln(), open(), close()

#### Element 类型

element.tagName.toLowerCase(),用来兼容HTML和XML中标签名称大小写不一致

*   HTML元素中的**属性**(property)和**特性**(attribute,characteristic) 属性可以看作是对象属性，一般就是不在元素标签中直接写出的，而特性就是标签中写出，大体上可以这样理解，但这是不准确的。
*   HTML元素(HTMLELement类型) HTMLElement继承自Element并新增了一些属性：id, title, lang, dir, className(class是js的关键字)
*   取得特性

    *   getAtrribute()：可以取得自定义特性（html5中加data-前缀）。
    *   setAtrribute()
    *   removeAtrribute()：彻底删除元素的特性 
    *   用getAtrribute()获得的特性style只是CSS文本，而属性sytle是CSSStyleDeclaration对象。想onclick这种事件处理程序的特性是js字符串，属性是js函数。
    *   一般在只有取得自定义特性值的情况下，才会使用getAttribute方法

*   `attributes`属性（NamedNodeMap对象，与Nodelist类似，是类数组的动态集合）  
    Element类型是使用attributes属性的唯一一个DOM节点类型。attributes属性含有所有元素特性(可以用于遍历元素的特性)和一些方法：

    *   getNameItem(name)
    *   removeNameItem(name)
    *   setNamedItem(node)
    *   item(pos)

*   创建元素 doucment.createElement('标签名')

*   元素的子节点

    *   元素的childNodes属性
    *   元素的getElementsByTagName()方法

#### Text类型

*   创建文本节点 document.createTextNode()
*   规范化文本节点  
    normalize() : 合并相邻的文本节点。  
    浏览器在解析文档时永远不会创建相邻的文本节点。
*   分割文本节点 splitText(offset):返回从offset开始以后的文本，原节点包括offset之前的文本
*   其他操作文本节点的方法 
    *   appendData(text)
    *   deleteData(offset, count)
    *   insertData(offset, text)
    *   replaceData(offset, count, text) 
    *   substringData(offset, count)

#### Comment 类型

Comment和Text类型继承自同一基类，方法、属性基本类似，除没有splitText()。

*   document.createComment()

#### CDATASection 类型

CDATASection 继承自Text，只针对XML文档，表示CDATA区域，多数浏览器会把它解释为Comment或Element类型。

*   document.createCDATASection()

#### DocumentType 类型

document.doctype

#### DocumentFragment 类型

DocumentFragment类型继承了所有Node的方法；不会占用额外的资源，可以当一个临时的仓库，保存需要操作的节点，这样就不需要浏览器的反复渲染，因为DOM的直接操作是很好资源的。 * document.createDocumentFragment()

#### Attr 类型

Attr类型用来表示元素的特性。而**特性就是存储在元素的attributes属性中的节点**。

<pre>var div = document.getElementById('mydiv');
alert(div.attributes[0] instanceof Attr );  //true
</pre>


*   document.createAttribute()
*   Attr类型有三个属性 name,value,specified

