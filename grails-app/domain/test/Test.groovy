package test

import grails.gorm.MultiTenant

class Test implements MultiTenant<Test> {

    String name

    def beforeValidate() {
        println "------------- BEFORE Test VALIDATE --------------"
    }

    def beforeInsert() {
        println "------------- BEFORE Test INSERT --------------"
    }

    def beforeUpdate() {
        println "------------- BEFORE Test UPDATE --------------"
    }

    static constraints = {
    }
}
