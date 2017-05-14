package soa.finki.ukim.mk.repositories;

import org.springframework.data.repository.CrudRepository;
import soa.finki.ukim.mk.models.Attachment;

/**
 * Created by DarkoM on 12.5.2017.
 */
public interface IAttachmentRepository extends CrudRepository<Attachment, Long> {
}
