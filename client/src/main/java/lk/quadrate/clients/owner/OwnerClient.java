package lk.quadrate.clients.owner;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(value = "owner")
//@RequestMapping("api/v1/owner")
public interface OwnerClient {

    @GetMapping(path = "api/v1/owner/{ownerId}")
    OwnerClientResponse getOwnerById(@PathVariable("ownerId") Long ownerId);

    @GetMapping(path = "api/v1/owner/user/{userId}")
    OwnerClientResponse getOwnerByUserId(@PathVariable("userId") String userId);
}
