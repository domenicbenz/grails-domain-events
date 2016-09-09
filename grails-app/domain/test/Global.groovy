package test

class Global {

    String name
    Integer foo = 0

    def beforeValidate() {
        println "------------- BEFORE Global VALIDATE --------------"
    }

    def beforeInsert() {
        println "------------- BEFORE Global INSERT --------------"
    }

    def beforeUpdate() {
        println "------------- BEFORE Global UPDATE --------------"
    }

    static constraints = {
    }
}
