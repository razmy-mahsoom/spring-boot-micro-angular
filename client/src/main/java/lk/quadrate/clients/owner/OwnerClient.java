package lk.quadrate.clients.owner;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.HttpRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.security.Principal;

@FeignClient(value = "owner")
public interface OwnerClient {

    @GetMapping(path = "api/v1/owner/{ownerId}")
    OwnerClientResponse getOwnerById(@PathVariable("ownerId") Long ownerId);
}
