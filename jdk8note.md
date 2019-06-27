1、筛选和切片

    1.1、谓词筛选
		filter:该操作会接受一个谓词（一个返回boolean的函数）作为参数，并返回一个包括所有符合谓词的元素的流
		eg:筛选所有符合isVegetarian的dish
        
        List<Dish> vegetarianMenu = menu.stream().filter(Dish::isVegetarian).collect(toList());
        
		
	1.2、筛选各异的元素
		distinct：它会返回一个元素各异（根据流所生成元素的hashCode和equals方法实现）的流
		eg：筛选所有偶数
		List<Integer> numbers = Arrays.asList(1, 2, 1, 3, 3, 2, 4); 
		numbers.stream().filter(i -> i % 2 == 0).distinct().forEach(System.out::println); 
		
	1.3、截短流
		limit(n):该方法会返回一个不超过给定长度的流。所需的长度作为参数传递给limit。
		eg：超过300卡路里的头三道菜
		List<Dish> dishes = menu.stream().filter(d -> d.getCalories() > 300).limit(3).collect(toList());
		
	1.4、跳过元素
		skip(n):返回一个扔掉了前n个元素的流。如果流中元素不足n个，则返回一个空流;limit(n)和skip(n)是互补的
		eg:跳过超过300卡路里的头两道菜，并返回剩下的
		List<Dish> dishes = menu.stream().filter(d -> d.getCalories() > 300).skip(2).collect(toList());
	
2、映射

	2.1、对流中每个元素应用函数
		map:它会接受一个函数作为参数。这个函数会被应用到每个元素上，并将其映射成一个新的元素（使用映射一词，是因为它和转换类似，但其中的细微差别在于它是“创建一个新版本”而不是去“修改”
		eg：提取流中菜肴的名称
		List<String> dishNames = menu.stream().map(Dish::getName).collect(toList());
	
	2.2、流的扁平化
		flatMap:flatmap方法让你把一个流中的每个值都换成另一个流，然后把所有的流连接起来成为一个流，即扁平化为一个流
		eg：给定单词列表["Hello","World"]，你想要返回列表["H","e","l", "o","W","r","d"]
		List<String> uniqueCharacters = words.stream().map(w -> w.split("")).flatMap(Arrays::stream).distinct().collect(Collectors.toList());
		注：Arrays.stream()的方法可以接受一个数组并产生一个流
		
3、查找和匹配

	（Java中&&和||运算符短路在流中的版本）
	3.1、检查谓词是否至少匹配一个元素
		anyMatch：流中是否有一个元素能匹配给定的谓词,法返回一个boolean，因此是一个终端操作
		eg:
		if(menu.stream().anyMatch(Dish::isVegetarian)){ 
			System.out.println("The menu is (somewhat) vegetarian friendly!!"); 
		}
		
	3.2、检查谓词是否匹配所有元素
		allMatch:方法的工作原理和anyMatch类似，但它会看看流中的元素是否都能匹配给定的谓词
	
	3.3、检查谓词是否未匹配到元素
		noneMatch：它可以确保流中没有任何元素与给定的谓词匹配

	3.4、查找任意元素
		findAny:将返回当前流中的任意元素
		eg:找到一道素食菜肴
		Optional<Dish> dish = menu.stream().filter(Dish::isVegetarian).findAny(); 
		
	3.5、查询第一个元素
		findFirst:
		eg:能找出第一个平方能被3整除的数
```
		List<Integer> someNumbers = Arrays.asList(1, 2, 3, 4, 5); 
		Optional<Integer> firstSquareDivisibleByThree = someNumbers.stream().map(x -> x * x).filter(x -> x % 3 == 0).findFirst(); 
		```
4、归约

	将流中所有元素反复结合起来，得到一个值，这样的查询可以被归类为归约操作（将流归约成一个值）
	用函数式编程语言的术语来说，这称为折叠（fold），因为你可以将这个操作看成把一张长长的纸（你的流）反复折叠成一个小方块，而这就是折叠操作的结果。
	reduce	
	reduce接受两个参数：
		一个初始值，这里是0； 
		一个BinaryOperator<T>来将两个元素结合起来产生一个新值
        
	5.1、元素求和
    
   ```
		int sum = numbers.stream().reduce(0, (a, b) -> a + b);		a的初始值为0，b为流中的元素，在累计过程中，a始终取前一次计算后的结果，b为流中下一个元素
		int sum = numbers.stream().reduce(0, Integer::sum);
		Optional<Integer> sum = numbers.stream().reduce((a, b) -> (a + b));
    ```    
	
    
	5.2、最大值和最小值
		Optional<Integer> max = numbers.stream().reduce(Integer::max);
		Optional<Integer> min = numbers.stream().reduce(Integer::min);
		
		map和reduce的连接通常称为map-reduce模式
		
6、数值流

	6.1、映射到数值流
		将流转换为特化版本的常用方法是mapToInt、mapToDouble和mapToLong。这些方法和前面说的map方法的工作方式一样，只是它们返回的是一个特化流，而不是Stream<T>
		eg:对menu中的卡路里求和
		int calories = menu.stream().mapToInt(Dish::getCalories).sum();
		
	6.2、转换回对象流
		IntStream 的 map 操作接受的 Lambda 必须接受 int 并返回 int （一个IntUnaryOperator）。
		eg:
		IntStream intStream = menu.stream().mapToInt(Dish::getCalories); 将Stream转换为数值流
		Stream<Integer> stream = intStream.boxed();将数值流转换为Stream
		
	6.3、默认值OptionalInt
		Optional原始类型特化版本：OptionalInt、OptionalDouble和OptionalLong。
		eg:
		OptionalInt maxCalories = menu.stream().mapToInt(Dish::getCalories).max(); 
		int max = maxCalories.orElse(1); 如果没有最大值的话，显式提供一个默认最大值
		
7、构建流
	
	7.1、由值创建流
		Stream.of
		eg:
		Stream<String> stream = Stream.of("Java 8 ", "Lambdas ", "In ", "Action");
		
	7.2、由数组创建流
		Arrays.stream
		eg:
		int[] numbers = {2, 3, 5, 7, 11, 13};
		int sum = Arrays.stream(numbers).sum();
		
	7.3、由文件生成流
		Files.lines
	
	7.4、由函数生成流：创建无限流 
		Stream.iterate和Stream.generate
			
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		