package com.epam.topic6.task2;

/**
 * Created by Timofey_Ryuzhov on 4/19/2016.
 */
@ClassProperties(
        name = "DocumentedClass",
        scope = "PUBLIC",
        author = "Franklin Benjamin",
        date = "01/04/1738",
        description = "This class can be documented with annotations",
        version = 1.0
)
public class DocumentedClass {

    @FieldProperties(
            name = "document",
            scope = "PROTECTED",
            description = "some document"
    )
    protected String document;


    @MethodProperties(
            name = "intPrinter",
            scope = "PRIVATE",
            params = {"int a - first argument", "int b - second argument"},
            description = "Prints integers"
    )
    private void intPrinter(int a, int b) {
        System.out.println("a = " + a + "; b = " + b);
    }

    @MethodProperties(
            name = "signDocument",
            scope = "PUBLIC",
            description = "Prints integers"
    )
    /*Type: METHOD
      Name: intPrinter
      Scope: PRIVATE
      Params:
        String document - signed document
      Description: Signs documents
    * */
    public void signDocument() {
        System.out.println("The signed document is " + this.document);
    }

    @MethodProperties(
            name = "setDocument",
            scope = "PUBLIC",
            params = {"String document - first argument"},
            description = "Set document name"
    )
    public void setDocument(String document) {
        this.document = document;
    }
}
