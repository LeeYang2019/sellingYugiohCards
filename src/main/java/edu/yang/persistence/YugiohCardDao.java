package edu.yang.persistence;

import edu.yang.entity.YugiohCard;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import javax.persistence.criteria.*;
import java.util.List;


/**
 * YugiohCard Dao
 * @author Lee Yang
 */
public class YugiohCardDao {

    private final Logger logger = LogManager.getLogger(this.getClass());
    SessionFactory sessionFactory = SessionFactoryProvider.getSessionFactory();

    /**
     * update Yugiohcard
     * @param card  yugiohcard to be inserted or updated
     */
    public void saveOrUpdate(YugiohCard card) {
        Session session = sessionFactory.openSession();
        session.saveOrUpdate(card);
        session.close();
    }

    /**
     * update a Yugiohcard
     * @param card  Yugiohcard to be inserted or updated
     */
    public int insert(YugiohCard card) {
        int id = 0;
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        id = (int)session.save(card);
        transaction.commit();
        session.close();
        return id;
    }

    /**
     * Delete a Yugiohcard
     * @param card Yugiohcard to be deleted
     */
    public void delete(YugiohCard card) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.delete(card);
        transaction.commit();
        session.close();
    }

    /**
     * @param id
     * @return card
     */
    public YugiohCard getByCardId(int id) {
        Session session = sessionFactory.openSession();
        YugiohCard YugiohCard = session.get( YugiohCard.class, id);
        session.close();
        return YugiohCard;
    }

    /**
     * gets a single card
     * @param cardName
     * @return card
     */
    public YugiohCard getByCardName(String cardName) {
        Session session = sessionFactory.openSession();
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<YugiohCard> query = builder.createQuery( YugiohCard.class );
        Root<YugiohCard> root = query.from( YugiohCard.class );
        Expression<String> propertyPath = root.get("cardName");
        query.where(builder.like(propertyPath, cardName));
        YugiohCard card = session.createQuery( query ).getSingleResult();
        session.close();
        return card;
    }

    /**
     * gets a list of cards with similar names
     * @param cardName
     * @return cards list of cards with similar names
     */
    public List<YugiohCard> getAllByCardName(String cardName) {
        Session session = sessionFactory.openSession();
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<YugiohCard> query = builder.createQuery( YugiohCard.class );
        Root<YugiohCard> root = query.from( YugiohCard.class );
        Expression<String> propertyPath = root.get("cardName");
        query.where(builder.like(propertyPath, "%" + cardName + "%"));
        List<YugiohCard> cards = session.createQuery( query ).getResultList();
        session.close();
        return cards;
    }

    /**
     * gets a list of cards with similar types
     * @param cardType
     * @return cards list of cards with similar types
     */
    public List<YugiohCard> getAllByCardType(String cardType) {
        Session session = sessionFactory.openSession();
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<YugiohCard> query = builder.createQuery( YugiohCard.class );
        Root<YugiohCard> root = query.from( YugiohCard.class );
        Expression<String> propertyPath = root.get("cardType");
        query.where(builder.like(propertyPath, "%" + cardType + "%"));
        List<YugiohCard> cards = session.createQuery( query ).getResultList();
        session.close();
        return cards;
    }

    /**
     * gets a list of cards with similar rarity
     * @param cardRarity
     * @return cards list of cards with similar rarity
     */
    public List<YugiohCard> getAllByCardRarity(String cardRarity) {
        Session session = sessionFactory.openSession();
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<YugiohCard> query = builder.createQuery( YugiohCard.class );
        Root<YugiohCard> root = query.from( YugiohCard.class );
        Expression<String> propertyPath = root.get("cardRarity");
        query.where(builder.like(propertyPath, "%" + cardRarity + "%"));
        List<YugiohCard> cards = session.createQuery( query ).getResultList();
        session.close();
        return cards;
    }

    /**
     * gets a list of cards with same sets
     * @param cardSet
     * @return cards list of cards with same sets
     */
    public List<YugiohCard> getAllByCardSet(String cardSet) {
        Session session = sessionFactory.openSession();
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<YugiohCard> query = builder.createQuery( YugiohCard.class );
        Root<YugiohCard> root = query.from( YugiohCard.class );
        Expression<String> propertyPath = root.get("cardSet");
        query.where(builder.like(propertyPath, "%" + cardSet + "%"));
        List<YugiohCard> cards = session.createQuery( query ).getResultList();
        session.close();
        return cards;
    }

    /**
     * Return a list of all yugiohcards
     * @return All Yugiohcards
     */
    public List<YugiohCard> getAll() {
        Session session = sessionFactory.openSession();
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<YugiohCard> query = builder.createQuery( YugiohCard.class );
        Root<YugiohCard> root = query.from( YugiohCard.class );
        List<YugiohCard> cards = session.createQuery( query ).getResultList();
        session.close();
        return cards;
    }


}


