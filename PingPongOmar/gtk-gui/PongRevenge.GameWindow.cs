
// This file has been generated by the GUI designer. Do not modify.
namespace PongRevenge
{
	public partial class GameEngineWindow
	{
		private global::Gtk.DrawingArea drawArea;

		protected virtual void Build ()
		{
			global::Stetic.Gui.Initialize (this);
			// Widget PongRevenge.GameWindow
			this.WidthRequest = 500;
			this.HeightRequest = 400;
			this.Name = "PongRevenge.GameWindow";
			this.Title = global::Mono.Unix.Catalog.GetString ("GameWindow");
			this.WindowPosition = ((global::Gtk.WindowPosition)(4));
			this.Resizable = false;
			// Container child PongRevenge.GameWindow.Gtk.Container+ContainerChild
			this.drawArea = new global::Gtk.DrawingArea ();
			this.drawArea.Name = "drawArea";
			this.Add (this.drawArea);
			if ((this.Child != null)) {
				this.Child.ShowAll ();
			}
			this.DefaultWidth = 658;
			this.DefaultHeight = 446;
			this.Show ();
		}
	}
}
