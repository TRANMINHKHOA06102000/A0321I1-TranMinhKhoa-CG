package b11_stack_queue.baitap.check_brackets_in_expressions_using_stack;
import java.util.*;
public class Expression{
    public static void main (String [] args)
    {
        String test_good = "()(){}{}{()}";
        String test_bad = "((({}{}))()";

        System.out.println(checkBalanced(test_good));
        System.out.println(checkBalanced(test_bad));
    }

    public static boolean checkBalanced(String check)
    {
        Stack<Character> stack = new Stack<Character>();
        for(int a = 0; a < check.length(); a++)
        {
            char let = check.charAt(a);
            if(let == '[' || let == '{' || let == '(')
                stack.push(let);
            else if(let == ']' || let == '}' || let == ')')
            {
                if(stack.empty())
                    return false;
                switch(let)
                {
                    // Opening square brace
                    case ']':
                        if (stack.pop() != '[')
                            return false;
                        break;
                    // Opening curly brace
                    case '}':
                        if (stack.pop() != '{')
                            return false;
                        break;
                    // Opening paren brace
                    case ')':
                        if (stack.pop() != '(')
                            return false;
                        break;
                    default:
                        break;
                }
            }
        }
        if(stack.empty())
            return true;
        return false;
    }
}