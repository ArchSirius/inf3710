package tp4.Model;

public abstract class Model
{
	protected tp4.Lib.Orm orm;

	public Model(tp4.Lib.Orm orm_)
	{
		orm = orm_;
	}
}