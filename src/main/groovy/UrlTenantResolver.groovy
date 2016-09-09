import groovy.transform.CompileStatic
import org.grails.datastore.mapping.core.connections.ConnectionSource
import org.grails.datastore.mapping.multitenancy.AllTenantsResolver
import org.grails.datastore.mapping.multitenancy.TenantResolver
import org.grails.datastore.mapping.multitenancy.exceptions.TenantNotFoundException
import org.springframework.web.context.request.RequestAttributes
import org.springframework.web.context.request.RequestContextHolder
import org.springframework.web.context.request.ServletWebRequest

/**
 * Created with IntelliJ IDEA.
 * User: Domenic Benz
 * Date: 31/08/16
 * Time: 16:51
 * To change this template use File | Settings | File Templates.
 */
//@CompileStatic
class UrlTenantResolver implements TenantResolver, AllTenantsResolver {
    @Override
    Serializable resolveTenantIdentifier() {

        RequestAttributes requestAttributes = RequestContextHolder.getRequestAttributes()
        if(requestAttributes instanceof ServletWebRequest) {

            def swr = (ServletWebRequest)requestAttributes

            def tenantParam = swr.params.tenant
            if( tenantParam ) {
                return tenantParam
            }
            else {
                return ConnectionSource.DEFAULT
            }
        }
        throw new TenantNotFoundException("Tenant could not be resolved outside a web request")
    }

    @Override
    Iterable<Serializable> resolveTenantIds() {
        Iterable<Serializable> allTenants = new ArrayList<>()
        allTenants.add("test-1")
        allTenants.add("test-2")
        return allTenants
    }
}
