#Построй дерево
## Построй дерево(4)
Итак, основа дерева создана, пора тебе поработать немного самому.
Вспомним как должно выглядеть наше дерево.

Элементы дерева должны следовать так как показано на картинке:
http://info.javarush.ru/uploads/images/00/04/89/2014/03/21/ee9a9b.jpg

Необходимо написать методы, которые бы позволили создать такую структуру дерева и проводить операции над ней.

Тебе необходимо реализовать:
1. метод add(String s) — добавляет элементы дерева, в качестве параметра принимает имя элемента (elementName), искать место для вставки начинаем слева направо.
2. метод remove(Object o) — удаляет элемент дерева имя которого было полученного в качестве параметра.
3. метод size() — возвращает текущее количество элементов в дереве.
4. метод getParent(String s) — возвращает имя родителя элемента дерева, имя которого было полученного в качестве параметра.


Требования:
1. После добавления N элементов в дерево с помощью метода add, метод size должен возвращать N.
2. После удаления последнего добавленного элемента из дерева с помощью метода remove, метод size должен возвращать N-1.
3. После удаления второго элемента добавленного в дерево, метод size должен возвращать N/2 + 1 (для случаев где N > 2 и является степенью двойки), N - размер дерева до удаления.
4. Метод getParent должен возвращать имя родителя для любого элемента дерева.

## Построй дерево(3)
   Класс описывающий дерево мы создали, теперь нужен класс описывающий тип элементов дерева:
   1.  В классе CustomTree создай вложенный статический параметризированный класс Entry<T> с модификатором доступа по умолчанию.
   2. Обеспечь поддержку этим классом интерфейса Serializable.
   3. Создай такие поля (модификатор доступа по умолчанию):
   — String elementName;
   — int lineNumber;
   — boolean availableToAddLeftChildren, availableToAddRightChildren;
   — Entry<T> parent, leftChild, rightChild;
   4. Реализуй публичный конструктор с одним параметром типа String:
   — установи поле elementName равным полученному параметру;
   — установи поле availableToAddLeftChildren равным true;
   — установи поле availableToAddRightChildren равным true;
   5. Реализуй метод void checkChildren, устанавливающий поле availableToAddLeftChildren в false, если leftChild не равен null и availableToAddRightChildren в false, если rightChild не равен null.
   6. Реализуй метод boolean isAvailableToAddChildren, возвращающий дизъюнкцию полей availableToAddLeftChildren и availableToAddRightChildren.
   
   Любое дерево начинается с корня, поэтому не забудь в класс CustomTree добавить поле root типа Entry<String> c модификатором доступа по умолчанию.
   
   
   Требования:
   1. Класс CustomTree.Entry должен быть объявлен с модификатором доступа по умолчанию.
   2. Класс CustomTree.Entry должен поддерживать интерфейс Serializable.
   3. В классе CustomTree.Entry должно существовать поле elementName типа String.
   4. В классе CustomTree.Entry должно существовать поле lineNumber типа int.
   5. В классе CustomTree.Entry должно существовать поле availableToAddLeftChildren типа boolean.
   6. В классе CustomTree.Entry должно существовать поле availableToAddRightChildren типа boolean.
   7. В классе CustomTree.Entry должно существовать поле parent типа Entry.
   8. В классе CustomTree.Entry должно существовать поле leftChild типа Entry.
   9. В классе CustomTree.Entry должно существовать поле rightChild типа Entry.
   10. В классе CustomTree.Entry должен быть корректно реализован конструктор с одним параметром типа String (смотри условие).
   11. В классе CustomTree.Entry должен корректно реализован метод checkChildren (смотри условие).
   12. В классе CustomTree.Entry должен корректно реализован метод isAvailableToAddChildren (смотри условие).
## Построй дерево(2)
   Несмотря на то что наше дерево является потомком класса AbstractList, это не список в привычном понимании.
   В частности нам недоступны принимающие в качестве параметра индекс элемента.
   Такие методы необходимо переопределить и бросить новое исключение типа UnsupportedOperationException.
   
   Вот их список:
   public String get(int index)
   public String set(int index, String element)
   public void add(int index, String element)
   public String remove(int index)
   public List<String> subList(int fromIndex, int toIndex)
   protected void removeRange(int fromIndex, int toIndex)
   public boolean addAll(int index, Collection<? extends String> c)
   
   
   Требования:
   1. При попытке вызвать метод get(int index) должно возникать исключение типа UnsupportedOperationException.
   2. При попытке вызвать метод set(int index, String element) должно возникать исключение типа UnsupportedOperationException.
   3. При попытке вызвать метод add(int index, String element) должно возникать исключение типа UnsupportedOperationException.
   4. При попытке вызвать метод String remove(int index) должно возникать исключение типа UnsupportedOperationException.
   5. При попытке вызвать метод subList(int fromIndex, int toIndex) должно возникать исключение типа UnsupportedOperationException.
   6. При попытке вызвать метод removeRange(int fromIndex, int toIndex) должно возникать исключение типа UnsupportedOperationException.
   7. При попытке вызвать метод addAll(int index, Collection c) должно возникать исключение типа UnsupportedOperationException.
##Построй дерево(1)
Амиго, похоже ты уже достаточно окреп. Самое время проверить свои навыки в большой задаче!
Сегодня реализуем свое дерево немного нестандартным способом(на базе AbstractList).
Вводную информацию можешь получить используя свой любимый поисковик и текст ниже.

Элементы дерева должны следовать так как показано на картинке:
http://info.javarush.ru/uploads/images/00/04/89/2014/03/21/ee9a9b.jpg

Для начала сделаем наше дерево потомком класса AbstractList с параметром типа String, а также
реализуем интерфейсы Cloneable и Serializable.

Реализацию методов get(int index) и size() пока оставь стандартной.


Требования:
1. Класс CustomTree должен поддерживать интерфейс Cloneable.
2. Класс CustomTree должен поддерживать интерфейс Serializable.
3. Класс CustomTree должен быть потомком класса AbstractList.